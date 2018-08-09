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
driver.get("http://192.168.99.100:8080/configure")
checkbox = driver.find_element_by_name("_.useAuthenticatedEndpoint")
if checkbox.is_selected():
    checkbox.click()
connection_name = driver.find_element_by_name("_.name")
connection_name.clear()
connection_name.send_keys("gitlab-connection")
url = driver.find_element_by_xpath("//input[@checkurl='/descriptorByName/com.dabsquared.gitlabjenkins.connection.GitLabConnectionConfig/checkUrl']")
url.clear()
url.send_keys("http://192.168.99.100:30080")
api_key = driver.find_element_by_xpath("//select[@fillurl='/descriptorByName/com.dabsquared.gitlabjenkins.connection.GitLabConnectionConfig/fillApiTokenIdItems']/option[text()='GitLab API token']").click()
button = driver.find_element_by_id("yui-gen29-button")
button.click()

#add maven
driver.get("http://192.168.99.100:8080/configureTools/")
driver.find_element_by_id("yui-gen13-button").click()
driver.find_element_by_id("yui-gen18-button").click()
maven_name = driver.find_element_by_xpath("//input[@checkurl='/descriptorByName/hudson.tasks.Maven$MavenInstallation/checkName']")
maven_name.clear()
maven_name.send_keys("jetty-app-maven")
driver.find_element_by_id("yui-gen25-button").click()


"""
driver.get("http://192.168.99.100:8080/credentials/store/system/domain/_/newCredentials")

username=sys.argv[1]
password=sys.argv[2]

setting = driver.find_element_by_xpath("//select[@class='setting-input dropdownList']/option[text()='Username with password']").click()
#setting = driver.find_element_by_name("0")
username_field = driver.find_element_by_name("_.username")
password_field = driver.find_element_by_name("_.password")
username_field.clear()
password_field.clear()
username_field.send_keys(username)
password_field.send_keys(password)
button = driver.find_element_by_id("yui-gen3-button")
button.click()

driver.get("http://192.168.99.100:8080/credentials/store/system/domain/_/newCredentials")

api_token=sys.argv[3]
setting = driver.find_element_by_xpath("//select[@class='setting-input dropdownList']/option[text()='GitLab API token']").click()
time.sleep(5)
#while "API token" not in driver.page_source:
#    pass
api_token_field = driver.find_element_by_name("_.apiToken")
api_token_field.clear()
api_token_field.send_keys(api_token)

button = driver.find_element_by_id("yui-gen3-button")
button.click()
"""
driver.close()
