<?php
//get tasklist array from POST
$task_list = filter_input(INPUT_POST, 'tasklist', FILTER_DEFAULT,                  
                          FILTER_REQUIRE_ARRAY);
if ($task_list === NULL) {
    $task_list = array();
}

//get action variable from POST
$action = filter_input(INPUT_POST, 'action');

//initialize error messages array
$errors = array();

//process
switch( $action ) {
    case 'add':
        $new_task = filter_input(INPUT_POST, 'task');
        if (empty($new_task)) {
            $errors[] = 'The new task cannot be empty.';
        } else {
            $task_list[] = $new_task;
        }
        break;
    case 'delete':
        $task_index = filter_input(INPUT_POST, 'taskid', FILTER_VALIDATE_INT);
        if ($task_index === NULL || $task_index === FALSE) {
            $errors[] = 'The task cannot be deleted.';
        } else {
            unset($task_list[$task_index]);
            $task_list = array_values($task_list);
        }
        break;
    /* =======================================================================
     * CODE MODIFICATIONS BELOW 
     * ======================================================================
     */ 
    // Added a demotion case
    case 'demote':
        // Gets task_index for task to be demoted
        $task_index = filter_input(INPUT_POST, 'taskid', FILTER_VALIDATE_INT);
        // If last task, throw error that you cannot demote last task
        if ($task_list[$task_index] === end($task_list)) {
            $errors[] = "You can't demote the last task.";
        } else {
            // Switches places with the task in the index above selected task
            // which is lower in priority. 
            $temp = $task_list[$task_index];
            $task_list[$task_index] = $task_list[$task_index + 1];
            $task_list[$task_index + 1] = $temp;
            $task_list = array_values($task_list);
        }
    /* =======================================================================
     * END OF CODE MODIFICATIONS 
     * ======================================================================
     */ 

}
include('task_list.php');
?>