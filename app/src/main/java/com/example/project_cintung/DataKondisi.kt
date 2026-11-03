package com.example.project_cintung

import android.content.Context
import android.content.Intent

val daftarKondisi = listOf(
    // tempel 6 KondisiModel dari KondisiFragment di sini
    KondisiModel(
        "Pingsan",
        "Korban tiba-tiba tidak sadarkan diri",
        R.drawable.ic_logo_fast_rescue_merah,
        "1. Baringkan korban telentang di tempat datar, lalu periksa napas dan ada tidaknya cedera.\n" +
                "2. Jika tidak ada cedera, naikkan kedua kaki korban sekitar 30 cm dari lantai.\n" +
                "3. Longgarkan pakaian yang ketat dan jangan beri makan atau minum.\n" +
                "4. Setelah sadar, bantu korban duduk perlahan.",
        "Hubungi bantuan jika korban tidak sadar dalam sekitar 1 menit, tidak bernapas normal (mulai RJP bila kamu terlatih), atau terluka saat jatuh.",
        "ACEP (American College of Emergency Physicians)",
        "https://emergencyphysicians.org/article/know-when-to-go/fainting"
    ),
    KondisiModel(
        "Luka / Pendarahan",
        "Luka terbuka dan keluarnya darah",
        R.drawable.ic_logo_fast_rescue_merah,
        "1. Pakai sarung tangan bila ada, lalu tekan luka dengan kuat dan terus-menerus memakai kain bersih atau kasa.\n" +
                "2. Jika memungkinkan, angkat bagian yang luka lebih tinggi dari jantung (hati-hati bila dicurigai patah tulang).\n" +
                "3. Jika darah merembes, jangan lepas kain pertama. Tambahkan kain di atasnya dan balut cukup kencang, tetapi tidak sampai menghentikan aliran darah ke ujung jari atau kaki.\n" +
                "4. Untuk luka kecil, setelah darah berhenti bersihkan dengan air mengalir lalu tutup dengan perban bersih.",
        "Hubungi bantuan jika darah tidak berhenti dengan tekanan, luka dalam, atau ada benda tertancap (jangan dicabut, tekan di kedua sisinya). Waspada bila korban pucat, berkeringat, atau pusing. Jangan beri makan atau minum.",
        "St John Ambulance",
        "https://firstaidforme.stjohnwa.com.au/?p=7796"
    ),
    KondisiModel(
        "Luka Bakar",
        "Terkena api, air panas, atau benda panas",
        R.drawable.ic_logo_fast_rescue_merah,
        "1. Jauhkan korban dari sumber panas seperti api, air panas, atau minyak panas.\n" +
                "2. Aliri luka dengan air mengalir bersuhu ruangan sekitar 15 sampai 20 menit. Jangan gunakan es atau air es.\n" +
                "3. Tutup luka dengan kain lembut atau kasa bersih yang dibasahi air dingin supaya tidak iritasi dan terinfeksi.\n" +
                "4. Jangan mengoleskan pasta gigi atau bahan lain, dan jangan memecahkan lepuhan.",
        "Setelah penanganan awal, tetap periksakan ke dokter atau rumah sakit. Hubungi bantuan darurat jika luka luas atau dalam.",
        "Kemenkes RI dan ANZBA (via Alomedika)",
        "https://keslan.kemkes.go.id/view_artikel/1206/penanganan-awal-luka-bakar"
    ),
    KondisiModel(
        "Tersedak",
        "Saluran napas tersumbat benda asing",
        R.drawable.ic_logo_fast_rescue_merah,
        "1. Nilai kondisi korban. Jika masih bisa batuk atau bicara, dampingi dan awasi. Jika tidak bisa bicara, batuk, atau bernapas, segera tolong dan minta orang lain menghubungi bantuan.\n" +
                "2. Berdiri di samping dan sedikit di belakang korban, lalu beri tepukan di punggung.\n" +
                "3. Jika sumbatan belum keluar, lakukan dorongan perut (manuver Heimlich) dari belakang, ulangi 6 sampai 10 kali hingga sumbatan keluar.\n" +
                "4. Jika korban tidak sadar, hubungi bantuan darurat dan lakukan RJP bila kamu terlatih.",
        "Langkah ini untuk dewasa dan anak di atas 1 tahun. Penanganan bayi di bawah 1 tahun serta ibu hamil atau orang obesitas berbeda, segera hubungi bantuan.",
        "Kemenkes RI",
        "https://keslan.kemkes.go.id/view_artikel/3115/tersedak-simak-cara-mengatasinya"
    ),
    KondisiModel(
        "Keseleo",
        "Cedera pada sendi, misalnya pergelangan kaki",
        R.drawable.ic_logo_fast_rescue_merah,
        "1. Istirahatkan: bantu korban duduk atau berbaring dan jangan bertumpu pada bagian yang cedera.\n" +
                "2. Kompres dingin: bungkus es atau kantong dingin dengan kain lembap, tempelkan sekitar 15 sampai 20 menit. Jangan langsung ke kulit.\n" +
                "3. Balut dengan perban elastis dengan tekanan cukup hingga melewati area cedera.\n" +
                "4. Tinggikan bagian yang cedera, misalnya diganjal bantal. Jika terasa kesemutan, turunkan sedikit.\n" +
                "5. Hindari kompres panas, alkohol, pijat, dan menggerakkan area cedera.",
        "Cari bantuan medis jika nyeri hebat, bagian tubuh tidak bisa digerakkan, atau dicurigai patah tulang. Jika ragu, perlakukan seperti patah tulang.",
        "St John Ambulance (Inggris dan Australia)",
        "https://www.sja.org.uk/first-aid-advice/sprains-and-strains/"
    ),
    KondisiModel(
        "Kecelakaan Ringan",
        "Terjatuh, terbentur, atau tersandung",
        R.drawable.ic_logo_fast_rescue_merah,
        "1. Periksa bahaya di sekitar, seperti lalu lintas, benda tajam, atau api, dan pastikan aman sebelum mendekat.\n" +
                "2. Cek respons korban dengan memanggil dan menepuk bahunya.\n" +
                "3. Jika korban tidak sadar atau cedera tampak berat, minta bantuan dan hubungi nomor darurat.\n" +
                "4. Periksa napas korban. Jika tidak bernapas normal, hubungi bantuan dan lakukan RJP bila kamu terlatih.\n" +
                "5. Rawat cedera ringan: luka kecil dibersihkan dengan air mengalir lalu ditutup perban bersih, dan memar atau keseleo dikompres dingin.",
        "Jangan pindahkan korban kecuali ada bahaya. Jika ragu apakah cedera ringan atau berat, anggap berat dan hubungi bantuan.",
        "St John Ambulance (rencana DRSABCD)",
        "https://firstaidforme.stjohnwa.com.au/?p=10434"
    )
)

fun bukaPanduan(context: Context, kondisi: KondisiModel) {
    val intent = Intent(context, PanduanActivity::class.java)
    intent.putExtra("EXTRA_NAMA", kondisi.nama)
    intent.putExtra("EXTRA_RINGKASAN", kondisi.ringkasan)
    intent.putExtra("EXTRA_LANGKAH", kondisi.langkah)
    intent.putExtra("EXTRA_BANTUAN", kondisi.bantuan)
    intent.putExtra("EXTRA_SUMBER", kondisi.sumber)
    intent.putExtra("EXTRA_URL", kondisi.url)
    intent.putExtra("EXTRA_ICON", kondisi.iconRes)
    intent.putExtra("EXTRA_NOMOR", daftarKondisi.indexOf(kondisi) + 1)
    context.startActivity(intent)
}