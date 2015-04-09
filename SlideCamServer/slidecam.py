import RPi.GPIO as GPIO
from bluetooth import *

GPIO.setmode(GPIO.BOARD)
Motor1A = 16
Motor1B = 18
Motor1E = 22
GPIO.setup(Motor1A, GPIO.OUT)
GPIO.setup(Motor1B, GPIO.OUT)
GPIO.setup(Motor1E, GPIO.OUT)

server_sock = BluetoothSocket(RFCOMM)
server_sock.bind(("", PORT_ANY))
server_sock.listen(1)

port = server_sock.getsockname()[1]

uuid = "5103a5f7-a434-4f86-a1c4-e9033ef184dc"

advertise_service(server_sock, "SlideCamServer",
                  service_id=uuid,
                  service_classes=[uuid, SERIAL_PORT_CLASS],
                  profiles=[SERIAL_PORT_PROFILE],
                  # protocols = [ OBEX_UUID ]
)

print "Waiting for connection on RFCOMM channel %d" % port

client_sock, client_info = server_sock.accept()
print "Accepted connection from ", client_info

try:
    while True:
        data = client_sock.recv(1024)
        if len(data) == 0: break
        if data == 'y':
            GPIO.output(Motor1A, GPIO.HIGH)
            GPIO.output(Motor1B, GPIO.LOW)
            GPIO.output(Motor1E, GPIO.HIGH)
            client_sock.send('Motor on\r\n')
            print "motor on"
        elif data == 'n':
            GPIO.output(Motor1E, GPIO.LOW)
            client_sock.send('Motor off\r\n')
            print "motor off"
        else:
            print "received [%s]" % data
except IOError:
    pass
except KeyboardInterrupt:
    print "disconnected"
    GPIO.cleanup()
    client_sock.close()
    server_sock.close()
    print "all done"