import 'dart:convert';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:http/http.dart' as http;

void sendDatatest() async {
  final url = Uri.parse('3.39.32.28:8080/user/signIn');

  final headers = {
    'Content-Type' : 'application/json'
  };

  final body = jsonEncode({
    'name' : 'test1',
    'email' : 'test2',
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