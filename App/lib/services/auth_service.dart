import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:firebase_auth/firebase_auth.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/cupertino.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:solution_challenge_mciet/screens/home.dart';
import 'package:solution_challenge_mciet/screens/login.dart';

class AuthService {
  // 1. handleAuthState()
  handleAuthState() {
    return StreamBuilder(
      stream: FirebaseAuth.instance.authStateChanges(),
      builder: (BuildContext context, snapshot) {
        if (snapshot.hasData) {
          return homePage();
        } else {
          return const LoginPage();
        }
      },
    );
  }

  // 2. signInWithGoogle()
  signInWithGoogle() async {
    final GoogleSignInAccount? gUser = await GoogleSignIn().signIn();

    final GoogleSignInAuthentication gAuth = await gUser!.authentication;

    final credential = GoogleAuthProvider.credential(
      accessToken: gAuth.accessToken,
      idToken: gAuth.idToken,
    );
    return await FirebaseAuth.instance.signInWithCredential(credential);

  }

  void sendData() async {
    final url = Uri.parse('3.39.32.28:8080/user/signIn');

    final headers = {
      'Content-Type' : 'application/json'
    };

    final body = jsonEncode({
      'name' : FirebaseAuth.instance.currentUser!.displayName!.toString(),
      'email' : FirebaseAuth.instance.currentUser!.email!.toString(),
    });

    http.Response response = await http.post(
        url,
        headers: headers,
        body: body
    );
    print(response.statusCode);
    if (response.statusCode == 200) {
      final data = jsonDecode(response.body);
      print(data);
    } else {
      throw Exception('Failed to load data');
    }
  }

    // 3. signOut()
  signOut() {
    FirebaseAuth.instance.signOut();
  }
}