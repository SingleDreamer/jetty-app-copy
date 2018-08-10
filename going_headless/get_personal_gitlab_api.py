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
driver.get("http://192.168.99.100:30080/profile/personal_access_tokens") # jenkins

if "Sign in" in driver.page_source:
    user = driver.find_element_by_id("user_login")
    user.clear()
    user.send_keys("root")
    pswd = driver.find_element_by_id("user_password")
    pswd.clear()
    pswd.send_keys("GitPass1!")
    pswd.send_keys(Keys.RETURN)

token_name = driver.find_element_by_id("personal_access_token_name")
token_name.clear()
token_name.send_keys("jetty-token")

gitlab_checkbox = driver.find_element_by_id("personal_access_token_scopes_api")
if not gitlab_checkbox.is_selected():
    driver.execute_script("arguments[0].click();", gitlab_checkbox)

driver.find_element_by_name("commit").click()

token = driver.find_element_by_id("created-personal-access-token").get_attribute("value")
driver.close()

print(token)
