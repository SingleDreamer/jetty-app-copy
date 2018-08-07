import os
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.options import Options


chrome_options = Options()
#chrome_options.add_argument("--headless")
chrome_options.binary_location = 'C:\Program Files (x86)\Google\Chrome\Application\chrome.exe'

driver = webdriver.Chrome(executable_path=os.path.abspath("chromedriver"),   chrome_options=chrome_options)
driver.get("http://192.168.99.100:8080") # jenkins_home

while "Unlock Jenkins" not in driver.page_source:
    pass

f= open("initialAdminPassword.txt","r")
fl =f.readlines()
initialAdminPassword = ""
for x in fl:
    initialAdminPassword = x
#print(initialAdminPassword)

pass_field = driver.find_element_by_id("security-token")
pass_field.clear()
pass_field.send_keys(initialAdminPassword)
#pass_field.send_keys(Keys.RETURN)
#submit_button = driver.find_element_by_xpath("//input[@value='continue'][@type='submit']")
#submit_button.click()
driver.implicitly_wait(15)

while "Customize Jenkins" not in driver.page_source:
    pass
#print("at plugin page")
close_button = driver.find_element_by_class_name("close")
close_button.click()
print("close")

while "Start" not in driver.page_source:
    pass
#driver.implicitly_wait(15)
start_button = driver.find_element_by_class_name("install-done")
start_button.click()
print("start")

driver.close()
