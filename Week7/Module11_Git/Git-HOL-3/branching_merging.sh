#!/bin/bash
# HOL 3 - Branching and Merging
# Student comment: Working with branches to build features safely

# Create and switch to feature branch
git checkout -b feature/login-page

# Create feature file
echo "Login Form Code" > login.txt
git add login.txt
git commit -m "Add login page feature"

# Switch back to main branch
git checkout main

# Merge feature branch into main
git merge feature/login-page

# Delete feature branch after merge
git branch -d feature/login-page
