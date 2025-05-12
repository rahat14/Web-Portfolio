enum class Section(val label: String) {
    About("ABOUT"),
    Experience("EXPERIENCE"),
    Projects("PROJECTS")
}


enum class SocialLink(val url: String) {
    Github("https://github.com/rahat14"),
    Linkedlin("https://www.linkedin.com/in/rahat-shovo/"),
    Facebook("https://www.facebook.com/profile.php?id=100076692103324")
}


enum class WindowSize {
    COMPACT,     // Mobile
    MEDIUM,      // Tablet or narrow desktop
    EXPANDED     // Full desktop / wide web
}