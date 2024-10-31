rootProject.name = "dodamCloneCoding"

include(
    "dodam-system-core",
    "dodam-in-system-available",
    "dodam-application"
)

include(
    "dodam-in-system-available:dodam-rds-client"
)

include(
    "dodam-system-domain:dodam-domain-rds",
)