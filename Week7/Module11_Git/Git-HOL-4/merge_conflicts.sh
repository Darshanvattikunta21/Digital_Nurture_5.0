#!/bin/bash
# HOL 4 - Merge Conflict Resolution
# Student comment: Simulating and resolving a merge conflict

git checkout -b feature-a
echo "Header color: Blue" > config.txt
git add config.txt
git commit -m "Set header color to blue"

git checkout main
echo "Header color: Red" > config.txt
git add config.txt
git commit -m "Set header color to red"

# Attempt merge to generate conflict
git merge feature-a

# Student Note: Manually edit config.txt to resolve conflict, then run:
# git add config.txt
# git commit -m "Resolved merge conflict manually"
