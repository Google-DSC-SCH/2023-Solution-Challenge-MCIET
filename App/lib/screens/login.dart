import 'package:flutter/material.dart';
import 'package:solution_challenge_mciet/api/google_sign_api.dart';
import 'package:solution_challenge_mciet/components/appname.dart';
import 'package:solution_challenge_mciet/components/square_tile.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:solution_challenge_mciet/services/auth_service.dart';
import 'package:solution_challenge_mciet/services/test.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({Key? key}) : super(key: key);

  @override
  State<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
          backgroundColor: Color(0xff3b6fa5),
          body: Center(
            child: Column(
              children: [
                const SizedBox(height: 70),

                // 앱 로고
                SizedBox(
                  child: Image.asset('lib/images/mciet_logo.png'),
                  height: 200,
                  width: 200,
                ),

                const SizedBox(height: 40),

                // 앱이름 문구
                Text_mciet(),

                const SizedBox(height: 50),

                // 문구
                Text(
                  'Thank you for coming to MCIET !',
                  style: TextStyle(color: Colors.white, fontSize: 20),
                ),

                const SizedBox(height: 50),

                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 25.0),
                  child: Row(
                    children: [
                      Expanded(
                          child: Divider(
                            thickness: 0.5,
                            color: Colors.white,
                          )),
                      Padding(
                        padding: const EdgeInsets.symmetric(horizontal: 10.0),
                        child: Text(
                          'Google Login',
                          style: TextStyle(fontSize: 15, color: Colors.white),
                        ),
                      ),
                      Expanded(
                          child: Divider(
                            thickness: 0.5,
                            color: Colors.white,
                          )),
                    ],
                  ),
                ),

                const SizedBox(height: 50),

                // 구글 아이콘 버튼
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    SquareTile(
                      onTap: () {
                        AuthService().signInWithGoogle();
                      },
                      imagePath: 'lib/images/google.png',
                    )
                  ],
                ),
                const SizedBox(height: 50),
                Text('We only allow Google login.',
                  style: TextStyle(
                      color: Colors.white,
                      fontSize: 15
                  ),)
              ],
            ),
          )),
    );
  }
}