#!/bin/bash
# HOL 1 - Git Setup Script
# Student comment: Setting up my local git configuration and repository

echo "Setting global user configuration..."
git config --global user.name "Rahul Kumar"
git config --global user.email "rahul.kumar@cognizant.com"

echo "Initializing local repository..."
git init

echo "Checking Git configuration..."
git config --list | grep user
