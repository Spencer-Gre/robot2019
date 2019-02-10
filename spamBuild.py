#Spam deploy command for up to a certain number of attempts

import sys
import os

attempts = 5
exit = 1
count = 0
while exit != 0 and count < attempts:
	command = 'gradlew deploy -PteamNumber=5142 --offline  -Dorg.gradle.java.home="C:\\Users\\Public\\frc2019\\jdk"'
	exit = os.system(command)
	print("EXIT: ",exit)
	count += 1

if count == attempts:
	print("BUILD WAS UNSUCCESSFUL AFTER " + str(attempts) + " ATTEMPTS")
else:
	print("SUCCESSFULLY BUILT")