import 'dart:convert';
import 'package:http/http.dart' as http;

import 'package:flutter/material.dart';

class memoPage extends StatefulWidget {
  const memoPage({Key? key}) : super(key: key);

  @override
  State<memoPage> createState() => _memoPageState();
}

class _memoPageState extends State<memoPage> {
  List<String> memos = [];
  String input = '';

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery
        .of(context)
        .size;
    return Scaffold(
      appBar: AppBar(
        elevation: 0,
        backgroundColor: Color(0xff3b6fa5),
        title: Text('M C I E T'),
        centerTitle: true,
      ),
      floatingActionButton: FloatingActionButton(
        backgroundColor: Color(0xff3b6fa5),
        onPressed: () {
          listmemoData();
          showDialog(
              context: context,
              builder: (BuildContext context) {
                return AlertDialog(
                  title: Text('Add Memo'),
                  content: TextField(
                    decoration: InputDecoration(hintText: "Memo"),
                    onChanged: (String value) {
                      input = value;
                    },
                  ),
                  actions: <Widget>[
                    Center(
                      child: ElevatedButton(
                          style: ElevatedButton.styleFrom(
                              backgroundColor: Color(0xff3b6fa5)),
                          onPressed: () {
                            setState(() {
                              memos.add(input);
                            });
                            sendmemoData();
                            Navigator.of(context).pop();
                          },
                          child: Text('Add')),
                    )
                  ],
                );
              });
        },
        child: Icon(
          Icons.add,
          color: Colors.white,
        ),
      ),
      body: Column(
        children: <Widget>[
          Container(
              height: size.height * 0.13,
              child: Stack(
                children: <Widget>[
                  Container(
                    height: size.height * 0.2 - 70,
                    decoration: BoxDecoration(
                        borderRadius: BorderRadius.only(
                            bottomLeft: Radius.circular(35),
                            bottomRight: Radius.circular(35)),
                        color: Color(0xff3b6fa5)),
                  ),
                  Positioned(
                      top: 10,
                      left: 0,
                      right: 0,
                      child: Container(
                        margin: EdgeInsets.symmetric(horizontal: 30),
                        height: 55,
                        decoration: BoxDecoration(
                          color: Colors.white,
                          borderRadius: BorderRadius.circular(20),
                        ),
                        child: Padding(
                          padding: const EdgeInsets.symmetric(horizontal: 7),
                          child: Center(
                            child: Text(
                              'My Memo',
                              style: TextStyle(
                                  fontSize: 19, fontWeight: FontWeight.bold),
                            ),
                          ),
                        ),
                      )),
                ],
              )),
          Flexible(
            child: Padding(
              padding: EdgeInsets.all(5),
              child: ListView.builder(
                  itemCount: memos.length,
                  itemBuilder: (BuildContext context, int i) {
                    return Dismissible(
                        key: Key(memos[i]),
                        child: Card(
                          elevation: 4,
                          margin: EdgeInsets.all(8),
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(15)),
                          child: ListTile(
                            title: Text(memos[i]),
                            trailing: IconButton(
                              icon: Icon(
                                Icons.delete,
                                color: Colors.red,
                              ),
                              onPressed: () {
                                deletememoData();
                                setState(() {
                                  memos.removeAt(i);
                                });
                              },
                            ),
                          ),
                        ));
                  }),
            ),
          )
        ],
      ),
    );
  }

  Future<String> sendmemoData() async {
    final url = Uri.parse('http://3.39.32.28:8080/memo/save');
    print('hi');

    final headers = {
      'Content-Type': 'application/json',
      'Authorization': ''
    };

    final body = jsonEncode({
      "contents": input
    });

    http.Response response = await http.post(
        url,
        headers: headers,
        body: body
    );
    print(response.statusCode);
    if (response.statusCode >= 200 && response.statusCode < 300) {
      print("성공");
      print(response.body);
    }
    else {
      print("실패");
    }

    return response.body;
  }

  Future<String> deletememoData() async {
    final url = Uri.parse('http://3.39.32.28:8080/memo/10');

    final headers = {
      'Content-Type': 'application/json',
      'Authorization': 'bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrYW5nSW5AZ21haWwuY29tIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY3OTgyMzg0NSwiZXhwIjoxNjc5ODQ1NDQ1fQ.MfpZTSQ-x4JLik25pdfLBbv73mozZPIZefVM3lY9FII'
    };

    http.Response response = await http.delete(
      url,
      headers: headers,
    );

    print(response.statusCode);
    if (response.statusCode >= 200 && response.statusCode < 300) {
      print("성공");
      print(response.body);
    }
    else {
      print("실패");
    }

    return response.body;
  }
  Future<String> listmemoData() async {
    final url = Uri.parse('http://3.39.32.28:8080/memo/list');

    final headers = {
      'Content-Type': 'application/json',
      'Authorization': 'bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrYW5nSW5AZ21haWwuY29tIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY3OTgyMzg0NSwiZXhwIjoxNjc5ODQ1NDQ1fQ.MfpZTSQ-x4JLik25pdfLBbv73mozZPIZefVM3lY9FII'
    };

    http.Response response = await http.get(
      url,
      headers: headers,
    );

    print(response.statusCode);
    if (response.statusCode >= 200 && response.statusCode < 300) {
      print("성공");

      for(int i = 0; i<jsonDecode(response.body)['data'].length; i++) {
        var mymemo = jsonDecode(response.body)['data'][i]['contents'];
        print(mymemo);
      }

      // print(response.body);
    }
    else {
      print("실패");
    }

    return response.body;
  }
}
