import socket

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect(('10.1.11.71', 12345))
    s.sendall(b'Hello world')