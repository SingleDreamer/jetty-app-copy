import os
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.options import Options
#from subprocess import call
#import sys, os

#import sys
#import subprocess
#from subprocess import Popen, PIPE


chrome_options = Options()
chrome_options.add_argument("--headless")
chrome_options.binary_location = 'C:\Program Files (x86)\Google\Chrome\Application\chrome.exe'

driver = webdriver.Chrome(executable_path=os.path.abspath("chromedriver"),   chrome_options=chrome_options)
driver.get("http://192.168.99.100:8080") # jenkins_home

while "Unlock Jenkins" not in driver.page_source:
    pass

#if "Unlock Jenkins" in driver.page_source:
    #print("unlocking jenkins\n")
    #os.chdir("..")
    #shellscript = subprocess.Popen(["get_jenkins_pswd.sh"], stdin=subprocess.PIPE)
    #shellscript.stdin.write("yes\n")
    #shellscript.stdin.close()
    #returncode = shellscript.wait()   # blocks until shellscript is done

    #os.system("ls")
    #os.system("cd .. && .\get_jenkins_pswd.sh")
    #os.system("get_jenkins_pswd.sh")
    #os.chdir("..")
    #os.system("source config.sh")
    #os.system('docker exec -it -uroot $JENKINS_NAME bash -c "cat var/jenkins_home/secrets/initialAdminPassword"')

    #call(["get_jenkins_pswd.sh", shell=True])

    # session = subprocess.Popen(['test.sh'], stdout=PIPE, stderr=PIPE)
    # stdout, stderr = session.communicate()
    #
    # if stderr:
    #     raise Exception("Error "+str(stderr))

    #subprocess.call('test.sh', shell=True)
    #output = subprocess.check_output('test.sh')
    #print(output)

driver.close()
