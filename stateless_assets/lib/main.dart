import 'package:flutter/material.dart';

void main() {
  runApp(const MaterialApp(
    home: Home()
  ));
}

class Home extends StatelessWidget {
  const Home({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Flutter app"),
        centerTitle: true,
      ),
      // body: const Image(
      //   image: AssetImage('assets/image2.png'),
      // ),
      body: Column(
        children: [
          Image(image: AssetImage('assets/image1.png')),
          Image(image: AssetImage('assets/image2.png')),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: (){ },
        child: const Text("click"),
      ),
    );
  }
}


