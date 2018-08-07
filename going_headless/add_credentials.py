import os
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.options import Options
import time

"""
chrome_options = Options()
chrome_options.add_argument("--headless")
chrome_options.binary_location = 'C:\Program Files (x86)\Google\Chrome\Application\chrome.exe'

driver = webdriver.Chrome(executable_path=os.path.abspath("chromedriver"),   chrome_options=chrome_options)
driver.get("http://192.168.99.100:8080/credentials/store/system/domain/_/newCredentials") # jenkins

api_token_username=""
api_token_password=""

api_token = driver.find_element_by_xpath("//select[@class='setting-input']/option[text()='GitLab API token']").click())
api_token_username_field = driver.find_element_by_name("_.username")
api_token_password_field = driver.find_element_by_name("_.password")
api_token_username_field.clear()
api_token_password_field.clear()
api_token_username_field.send_keys(api_token_username)
api_token_password_field.send_keys(api_token_password)

button = driver.find_element_by_id("yui-gen3-button")
"""
