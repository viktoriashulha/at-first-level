package com.epam.at.shulha.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
  protected   WebDriver driver ;
  protected abstract AbstractPage openPage();
  protected final int WAIT_TIMEOUT_SECONDS = 10;

  public AbstractPage(WebDriver driver) {
    this.driver = driver;
  }
}
