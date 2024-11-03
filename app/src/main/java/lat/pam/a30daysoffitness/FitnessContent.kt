package lat.pam.a30daysoffitness

data class FitnessContent(
    val day: Int,
    val title: String,
    val description: String,
    val imageResId: Int = R.drawable.ic_launcher_foreground
)