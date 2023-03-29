import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:solution_challenge_mciet/screens/home.dart';
import 'package:solution_challenge_mciet/screens/itemdetail.dart';
import '';
import 'package:solution_challenge_mciet/screens/additem.dart';
import 'package:solution_challenge_mciet/screens/myref.dart';
import 'package:solution_challenge_mciet/services/auth_service.dart';
import 'package:get/get.dart';


void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  runApp(const Mciet());
}

class Mciet extends StatelessWidget {
  const Mciet({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      debugShowCheckedModeBanner: false, // debug 표시 제거
      title: 'Mceit',
      home: AuthService().handleAuthState(),
      getPages: [
        GetPage(
            name: '/myref',
            page: () => myrefPage()
        ),
        GetPage(
            name: '/home',
            page: () => homePage()
        ),
        GetPage(
            name: '/detail',
            page: () => ItemDetails()
        ),
      ],
    );
  }
}