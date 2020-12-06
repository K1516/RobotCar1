import paho.mqtt.client as mqtt
import RPi.GPIO as GPIO
import time
import os
import sys
from Tkinter import *
#haloo

def init():
	GPIO.setmode(GPIO.BOARD)
	GPIO.setup(7, GPIO.OUT)
	GPIO.setup(11, GPIO.OUT)
	GPIO.setup(13, GPIO.OUT)
	GPIO.setup(15, GPIO.OUT)

def on_connect(client, userdata, flags, rc):
	print("Connected with result code " + str(rc))
	client.subscribe("movement/move")

def on_message(client, userdata, msg):
	init()
	teksti = str(msg.payload)
	print(teksti)

	if teksti == "w":
		forward()
	if teksti == "s":
		backward()
	if teksti == "a":
		turn_left()
	if teksti == "d":
		turn_right()

def forward():
	GPIO.output(7, False)
	GPIO.output(11, True)
	GPIO.output(13, True)
	GPIO.output(15, False)
	time.sleep(1)
	GPIO.cleanup()

def backward():
	GPIO.output(7, True)
	GPIO.output(11, False)
	GPIO.output(13, False)
	GPIO.output(15, True)
	time.sleep(1)
	GPIO.cleanup()

def turn_right():
	GPIO.output(7, False)
	GPIO.output(11, True)
	GPIO.output(13, False)
	GPIO.output(15, True)
	time.sleep(1)
	GPIO.cleanup()

def turn_left():
	GPIO.output(7, True)
	GPIO.output(11, False)
	GPIO.output(13, True)
	GPIO.output(15, False)
	time.sleep(1)
	GPIO.cleanup()


client = mqtt.Client()
client.on_connect = on_connect
client.on_message = on_message
client.connect("192.168.1.105", 1883, 60)

client.loop_forever()
