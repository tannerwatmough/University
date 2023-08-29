// ====================
// Student: Tanner Watmough
// ID: T00712721
// Course: COMP3271 Computer Networks
// References: 
// https://www.geeksforgeeks.org/tcp-server-client-implementation-in-c/
// Project Part 2, Thompson Rivers University. 
// =========================

// TCP echo client program
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define MAX 80


//	Loop while receiving data... 
//		print data...
// 	end-while loop  
void senddata(int sock) {
    char buff[MAX];
    int n;
    for (;;) {
        bzero(buff, sizeof(buff));
        printf("Enter next command: ");
        n = 0;
        while ((buff[n++] = getchar()) != '\n');
        write(sock, buff, sizeof(buff));
        bzero(buff, sizeof(buff));
        // Receive data back from the server..
        read(sock, buff, sizeof(buff));
        printf("From Server: %s", buff);

        if ((strncmp(buff, "exit", 4)) == 0) {
            printf("Client Exit...\n");
            break;
        }
    }
}


int main (int argc, char* argv[ ])		// Three arguments to be checked later
{
	struct sockaddr_in servAddr;		// Server socket address data structure
	char *servIP = argv[1];				// Server IP address from command line
	int servPort = atoi(argv[2]);		// Server port number from command line
	char *message = argv[3];			// Message specified on the command line

	// Check for correct number of command line arguments
	if(argc != 4) {                                               
		printf("tcp-echo-client [IP address] [Port] [Message]\n");                             
		exit (1);
	}                                                

	// Populate socket address for the server
	memset (&servAddr, 0, sizeof(servAddr));		// Initialize data structure
	servAddr.sin_family = AF_INET; 					// This is an IPv4 address
	servAddr.sin_addr.s_addr = inet_addr(servIP); 	// Server IP address
	servAddr.sin_port = servPort;					// Server port number
	
	// Create a TCP socket stream
	int sock;
	if ((sock = socket (AF_INET, SOCK_STREAM, IPPROTO_TCP)) == -1) {
		printf("Error: socket creation failed!\n");
		exit (1);
	}
	else
        printf("Socket successfully created..\n"); 

	// Connect  to the server
	if ((connect (sock, (struct sockaddr*)&servAddr, sizeof(servAddr))) == -1) {
		printf("Error: connection to the server failed!\n");
		exit (1);
	}
	 else
        printf("Connected to the server..\n"); 
	
	// Students to complete this section

	// Send data to the server...
    write(sock, message, sizeof(message));
    read(sock, message, sizeof(message));
    printf("From Server: %s\n", message);
    if ((strcmp(message, "exit")) == 0) {
        printf("Client Exiting...\n");
        exit(0);
    }
    senddata(sock);
    
		


	// Close socket
	close(sock);
	
	// Stop program
	exit (0);
	
} // End main