import os
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.options import Options
import time
import sys


chrome_options = Options()
#chrome_options.add_argument("--headless")
chrome_options.binary_location = 'C:\Program Files (x86)\Google\Chrome\Application\chrome.exe'

driver = webdriver.Chrome(executable_path=os.path.abspath("chromedriver"),   chrome_options=chrome_options)
driver.get("http://192.168.99.100:8080") # jenkins


if "log in" in driver.page_source:
    f= open("initialAdminPassword.txt","r")
    fl =f.readlines()
    initialAdminPassword = ""
    for x in fl:
        initialAdminPassword = x
    user_field = driver.find_element_by_name("j_username")
    user_field.clear()
    user_field.send_keys("admin")
    pass_field = driver.find_element_by_name("j_password")
    pass_field.clear()
    pass_field.send_keys(initialAdminPassword)
    #pass_field.send_keys(Keys.RETURN)


#add gitlab webhook
driver.get("http://192.168.99.100:8080/view/all/newJob")

job_name = driver.find_element_by_name("name")
job_name.clear()
job_name.send_keys("jetty-gitlab-test") # might need to change
job_type = driver.find_element_by_xpath("//span[text()='Pipeline']").click()
driver.find_element_by_id("ok-button").click()

time.sleep(2)

gitlab_checkbox = driver.find_element_by_name("com-dabsquared-gitlabjenkins-GitLabPushTrigger")
if not gitlab_checkbox.is_selected():
    driver.execute_script("arguments[0].click();", gitlab_checkbox)


driver.find_element_by_xpath("//select[@class='setting-input dropdownList']/option[text()='Pipeline script from SCM']").click()
time.sleep(1)
driver.find_element_by_xpath("//select[@class='setting-input dropdownList']/option[text()='Git']").click()
time.sleep(1)
repo_url = driver.find_element_by_name("_.url")
repo_url.clear()
repo_url.send_keys("http://root@192.168.99.100:30080/root/jetty-app.git")

driver.find_element_by_xpath("//select[@name='_.credentialsId']/option[@value='gitlab-root']").click()

button = driver.find_element_by_xpath("//button[text()='Save']")
button.click()

driver.close()
