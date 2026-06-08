# AEM-Data-Repository

## Overview

This repository contains an Adobe Experience Manager (AEM) project developed using the AEM Maven Archetype.

The project includes custom components such as:

* Weather Component
* Carousel Component
* Sling Models
* HTL Components
* Client Libraries (CSS/JS)

---

## Technology Stack

* AEM 6.5 / AEM as a Cloud Service
* Java 11
* Maven 3.9+
* HTL (Sightly)
* Sling Models
* JavaScript
* CSS

---

## Project Structure

mysite/
├── all
├── core
├── dispatcher
├── ui.apps
├── ui.apps.structure
├── ui.config
├── ui.content
├── ui.frontend
├── ui.tests
└── it.tests

---

## Local Setup

### Prerequisites

* Java 11
* Maven 3.9+
* AEM SDK Author Instance
* Git

### Clone Repository

git clone https://github.com/truptiyande8/AEM-Data-Repository.git

### Build Project

mvn clean install

### Deploy to Local AEM

mvn clean install -PautoInstallSinglePackage

---

# Weather Component

## Description

The Weather Component retrieves weather information from an external weather API and displays the details on an AEM page.

### Features

* Configurable city name
* API integration
* Sling Model implementation
* JSON Export support

### Authoring Page

http://localhost:4502/editor.html/content/mysite/us/en/testing.html

### Published Page

http://localhost:4502/content/mysite/us/en/testing.html

### JSON Endpoint

http://localhost:4502/content/mysite/us/en/testing.model.json

### Component Path

/apps/mysite/components/weather

### Sling Model

com.mysite.core.models.WeatherModel

### Configuration

The component requires:

* Weather API Endpoint URL
* API Key

These values should be configured through OSGi Configuration and must not be committed to source control.

Example:

Endpoint:
https://api.weather-provider.com

API Key: <configure-in-local-environment>

---

# Carousel Component

## Description

The Carousel Component displays multiple slides with navigation controls.

### Features

* Previous / Next Navigation
* Responsive Design
* Authorable Slide Content
* Custom CSS and JavaScript

### Authoring Page

http://localhost:4502/editor.html/content/mysite/us/en/testing.html

### Published Page

http://localhost:4502/content/mysite/us/en/testing.html

### Component Path

/apps/mysite/components/carousel

### Implementation

* Sling Model
* HTL
* Client Libraries
* JavaScript Navigation Logic
* CSS Styling

### Supported Content

* Images
* Titles
* Descriptions
* CTA Links

---

## Development Workflow

### Create Feature Branch

git checkout -b feature/carousel-component

### Commit Changes

git add .
git commit -m "Added carousel component"

### Push Branch

git push -u origin feature/carousel-component

### Create Pull Request

Create a Pull Request from:

feature/carousel-component
main

---

## Repository

GitHub Repository:

https://github.com/truptiyande8/AEM-Data-Repository

---

## Author

Trupti Yande
AEM Developer
