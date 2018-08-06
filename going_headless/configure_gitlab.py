import os
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.options import Options

chrome_options = Options()
chrome_options.add_argument("--headless")
chrome_options.binary_location = 'C:\Program Files (x86)\Google\Chrome\Application\chrome.exe'

driver = webdriver.Chrome(executable_path=os.path.abspath("chromedriver"),   chrome_options=chrome_options)
driver.get("http://192.168.99.100:30080") # gitlab


#print(driver.page_source)
if "create password" in driver.page_source:

    pass_field = driver.find_element_by_id("user_password")
    pass_conf_field = driver.find_element_by_id("user_password_confirmation")
    pass_field.clear()
    pass_conf_field.clear()
    pass_field.send_keys("*HnYnKkn4869")
    pass_conf_field.send_keys("*HnYnKkn4869")
    pass_conf_field.send_keys(Keys.RETURN)
#assert "This field is required" in driver.page_source
driver.close()
