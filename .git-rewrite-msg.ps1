param([string]$file)
# Write the new commit message based on which commit is being reworded
switch ($env:GIT_COMMIT) {
    '2a41205' { Write-Output 'Week1: Module1 Design Patterns exercises' | Set-Content $file; break }
    '2658651' { Write-Output 'Week2: Module2 DSA exercises' | Set-Content $file; break }
    'c1c8783' { Write-Output 'Week3: Spring Core and Spring Data JPA exercises' | Set-Content $file; break }
    default { # leave message unchanged
        Get-Content -Raw $file | Set-Content $file
    }
}
