#!/bin/bash
# HOL 2 - Basic Workflow
# Student comment: Simple commands to track and save changes in Git

# Create sample file
echo "Welcome to DN5 Program" > sample.txt

# Check git status
git status

# Stage the file
git add sample.txt

# Commit changes
git commit -m "Initial commit: Added sample.txt"

# View commit history
git log --oneline
