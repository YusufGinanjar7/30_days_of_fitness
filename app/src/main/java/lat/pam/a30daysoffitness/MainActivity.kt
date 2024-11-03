package lat.pam.a30daysoffitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lat.pam.a30daysoffitness.ui.theme._30DaysOfFitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysOfFitnessTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    FitnessScreen(
                        fitnessContentList = sampleFitnessContent(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FitnessScreen(
    fitnessContentList: List<FitnessContent>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(fitnessContentList) { content ->
            FitnessCard(fitnessContent = content)
        }
    }
}

@Composable
fun FitnessCard(fitnessContent: FitnessContent) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { expanded = !expanded },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Hari ${fitnessContent.day}",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = fitnessContent.title, style = TextStyle(fontSize = 18.sp))

            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = fitnessContent.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            AnimatedVisibility(visible = expanded) {
                Column {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = fitnessContent.description, style = TextStyle(
                        fontSize = 16.sp
                    ))
                }
            }
        }
    }
}

fun sampleFitnessContent(): List<FitnessContent> {
    return listOf(
        FitnessContent(1, "Stretching", "Lakukan pemanasan selama 20 menit.", R.drawable.streching),
        FitnessContent(2, "Walking", "Berjalan cepat selama 30 menit.", R.drawable.walking),
        FitnessContent(3, "Yoga", "Lakukan yoga selama 30 menit.", R.drawable.yoga),
        FitnessContent(4, "Upper Body Strength", "Latihan kekuatan tubuh bagian atas.", R.drawable.upper_body),
        FitnessContent(5, "Core Workout", "Lakukan latihan inti selama 20 menit.", R.drawable.core_workout),
        FitnessContent(6, "Running", "Berlari selama 20 menit.", R.drawable.running),
        FitnessContent(7, "Lower Body Strength", "Latihan kekuatan tubuh bagian bawah.", R.drawable.lower_body),
        FitnessContent(8, "Active Recovery", "Lakukan pemulihan aktif dengan peregangan.", R.drawable.recovery_streching),
        FitnessContent(9, "Zumba", "Zumba selama 30 menit.", R.drawable.zumba),
        FitnessContent(10, "Nature Walk", "Berjalan di alam selama 1 jam.", R.drawable.nature_walkk),
        FitnessContent(11, "HIIT", "Latihan HIIT selama 20 menit.", R.drawable.hiit),
        FitnessContent(12, "Circuit Training", "Lakukan latihan sirkuit.", R.drawable.circuit_training),
        FitnessContent(13, "Meditation", "Lakukan meditasi selama 15 menit.", R.drawable.meditation),
        FitnessContent(14, "Cycling", "Bersepeda selama 30 menit.", R.drawable.cycling),
        FitnessContent(15, "Plyometric", "Lakukan latihan plyometric.", R.drawable.plyometric),
        FitnessContent(16, "Recovery Yoga", "Yoga pemulihan selama 30 menit.", R.drawable.ic_launcher_background),
        FitnessContent(17, "Breathing Exercises", "Lakukan latihan pernapasan.", R.drawable.ic_launcher_background),
        FitnessContent(18, "Kettlebell", "Latihan kettlebell.", R.drawable.ic_launcher_background),
        FitnessContent(19, "Swimming", "Berenang selama 30 menit.", R.drawable.ic_launcher_background),
        FitnessContent(20, "Walking in Place", "Lakukan latihan jalan di tempat.", R.drawable.ic_launcher_background),
        FitnessContent(21, "Strength Yoga", "Latihan yoga kekuatan.", R.drawable.ic_launcher_background),
        FitnessContent(22, "Skipping Rope", "Latihan kardio dengan skipping rope.", R.drawable.ic_launcher_background),
        FitnessContent(23, "Pilates", "Lakukan Pilates selama 30 menit.", R.drawable.ic_launcher_background),
        FitnessContent(24, "Treadmill", "Berjalan di treadmill selama 30 menit.", R.drawable.ic_launcher_background),
        FitnessContent(25, "Dumbbell", "Latihan kekuatan dengan dumbbell.", R.drawable.ic_launcher_background),
        FitnessContent(26, "Resistance Band", "Latihan kekuatan dengan resistance band.", R.drawable.ic_launcher_background),
        FitnessContent(27, "Guided Meditation", "Lakukan sesi meditasi terarah.", R.drawable.ic_launcher_background),
        FitnessContent(28, "Relaxed Jogging", "Lakukan jogging santai.", R.drawable.ic_launcher_background),
        FitnessContent(29, "Full Body Workout", "Lakukan latihan tubuh penuh (full body workout).", R.drawable.ic_launcher_background),
        FitnessContent(30, "Fitness Evaluation", "Lakukan evaluasi kegiatan fitness dan buat rencana untuk bulan berikutnya.", R.drawable.ic_launcher_background)
    )
}



@Preview(showBackground = true)
@Composable
fun FitnessScreenPreview() {
    _30DaysOfFitnessTheme {
        FitnessScreen(fitnessContentList = sampleFitnessContent())
    }
}
