package com.tutorial.helper;

import org.springframework.stereotype.Component;

@Component // secara otomatis Spring akan membuatkan bean untuk class tersebut
public class StringHelper {

    public boolean isPalindrome(String value) {

        // Palindrome adalah sebuah method yang mengecek apakah sebuah kata di bolak balik sama atau tidak

        // public StringBuilder(String str) // Membuat pembuat string yang diinisialisasi ke konten string yang ditentukan.
        // StringBuilder reverse() // Menyebabkan urutan karakter ini diganti dengan kebalikan dari urutan.
        // String toString() // Mengembalikan string yang mewakili data dalam urutan ini.
        String reverse = new StringBuilder(value).reverse().toString();
        return value.equals(reverse); // boolean equals(Object anObject) // Membandingkan string ini dengan objek yang ditentukan. Hasilnya adalah true jika dan hanya jika argumennya bukan null dan merupakan String objek yang mewakili urutan karakter yang sama dengan objek ini.
    }

}
