/*
* copy a file to another file
*/
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h> // These four header files are necessary to use file i/o functions.
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
/* argv[1]: from */
/* argv[2]: to */
int main(int argc, char* argv[])
{
    int in, out;
    in = open(argv[1], O_RDONLY); // O_RDONLY is defined in /usr/include/sys/types.h
    if (in < 0) {
        printf("Cannot open the file %s\n", argv[1]);
        exit(1);
    }
    out = open(argv[2], O_WRONLY | O_TRUNC | O_CREAT, S_IRUSR | S_IWUSR);
    if (out < 0) {
        printf("Cannot create the file %s\n", argv[2]);
        exit(1);
    }

    // read some bytes from in and write them into out.
    char* text = (char*)calloc(100, sizeof(char));
    int sz;
    sz = read(in, &text, 8);

    // print those bytes onto the screen while copying.
    printf("Called read(%d, c, 10). Returned that %d bytes were read. \n", in, sz);
    text[sz] = '\0';
    printf("Those bytes are as follows: %s\n", text);

    write(out, &text, strlen(text));
    close(in);
    close(out);



    // test if the two files have the exactly same contents, and print the result
}
