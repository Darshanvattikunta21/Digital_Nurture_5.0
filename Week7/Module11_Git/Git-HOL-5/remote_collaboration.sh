#!/bin/bash
# HOL 5 - Remote Repositories
# Student comment: Linking local repo to GitHub origin

# Add remote origin
git remote add origin https://github.com/your-username/CZT_DN5.git

# Set main branch
git branch -M main

# Push changes to remote repository
git push -u origin main

# Fetch and pull remote updates
git fetch origin
git pull origin main
