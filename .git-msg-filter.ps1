switch ($env:GIT_COMMIT) {
    '2a41205' { Write-Output 'Week1: Module1 Design Patterns exercises' ; break }
    '2658651' { Write-Output 'Week2: Module2 DSA exercises' ; break }
    'c1c8783' { Write-Output 'Week3: Spring Core and Spring Data JPA exercises' ; break }
    default { Get-Content -Raw - }
}
