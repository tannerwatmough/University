// ====================
// Student: Tanner Watmough
// ID: T00712721
// Course: COMP3271 Computer Networks
// References: 
// https://www.geeksforgeeks.org/tcp-server-client-implementation-in-c/
// Project Part 2, Thompson Rivers University. 
// =========================

//TCP Echo server program
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define	BUFLEN	512									// Maximum length of buffer
#define PORT	9988								// Fixed server port number

int main ()
{
	struct sockaddr_in server_address;		// Data structure for server address
	struct sockaddr_in client_address;		// Data structure for client address

    // Added variables
    char buffer[BUFLEN];
		
	// ======================================
	// Populate socket address for the server
    // =======================================

    // Initialize server address data structure
	memset(&server_address, 0, sizeof (server_address));   
    // Populate family field - IPV4 protocol
	server_address.sin_family = AF_INET;
    // Set port number 			        
	server_address.sin_port = PORT;
    // Set IP address to IPv4 value for loacalhost					        
	server_address.sin_addr.s_addr = INADDR_ANY;            
	 	
	// Create a TCP socket; returns -1 on failure
	int listen_sock, send_sock;
	if ((listen_sock = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP)) == -1) {
		printf("Error: Listen socket failed!\n");
		exit (1);
	}

	// Bind the socket to the server address; returns -1 on failure
	if ((bind(listen_sock, (struct sockaddr *) &server_address, sizeof(server_address))) == -1) {
		printf("Error: binding failed!\n");
		exit (1);
	}
	
	// printf("Server not fully implemented...\n");
	// Students to complete this section
	
	// Listen for connections...

    if ((listen(listen_sock, PORT)) == -1) {
        printf("Error: could not listen on socket\n");
    }

	printf("Server is listening on port: %d\n", PORT);
    printf("Waiting for client request...\n");
	printf("Press CTRL + C to exit\n");

    while(1) {
		socklen_t client_address_len = sizeof(client_address);
        
        // Accept connections from client...
        if ((send_sock = accept(listen_sock, (struct sockaddr *) &client_address, 
            &client_address_len)) == -1) {
            printf("Error: could not establish a new conneciton\n");
        }

        // Listens to receieve message from client. 
        while(1) {
            // Receive and format the data...
            int read = recv(send_sock, buffer, BUFLEN, 0);

            if(strcmp(buffer, "") != 0) {
                printf("From Client: %s\n", buffer);
            }
            if (!read) {
                break;
            } else if (read < 0) {
                printf("Error: client read failure\n");
            }

            // Echo data back to the client...
            if((send(send_sock, buffer, read, 0)) == -1) {
                printf("Error: client write failed\n");
            }

            // Clears buffer if exiting and awaits new connection message.
            if (strncmp(buffer, "exit", 4) == 0) {
                printf("Client connection terminated.\n");
                printf("Server listening for new connection...\n");
                bzero(buffer, sizeof(buffer));
            }
        }
	}

    close(listen_sock);	// Close descriptor referencing server socket

    exit(0);

	
	
		
	
} // End main
