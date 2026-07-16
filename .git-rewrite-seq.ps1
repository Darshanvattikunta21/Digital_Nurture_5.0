param([string]$file)
# Mark the specific commits to be reworded during interactive rebase
(Get-Content -Raw $file) -replace 'pick 2a41205 ', 'reword 2a41205 ' -replace 'pick 2658651 ', 'reword 2658651 ' -replace 'pick c1c8783 ', 'reword c1c8783 ' | Set-Content $file
