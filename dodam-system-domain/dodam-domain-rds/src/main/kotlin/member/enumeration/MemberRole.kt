package member.enumeration

enum class MemberRole(
    val role: String,
    val number: Int) {
    STUDENT("ROLE_STUDENT", 1),
    PARENT("ROLE_PARENT", 2),
    TEACHER("ROLE_TEACHER", 3),
    ADMIN("ROLE_ADMIN", 4);
    companion object {
        fun of(number: Int): MemberRole? {
            return entries.find { it.number == number }
        }
    }
}