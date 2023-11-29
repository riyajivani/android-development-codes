import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
      appBar: AppBar(
        title: const Text('flutter app'),
        centerTitle: true,
      ),
      body: const Center(
        child: Text('Hello devs'),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: (){ },
        child: const Text('click'),
      ),
    ),
  ));
}

