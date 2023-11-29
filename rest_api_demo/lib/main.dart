import 'todo.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart';

void main() {
  runApp(const MaterialApp(
   home: Home()
  ));
}

class Home extends StatefulWidget
{
  const Home({super.key});

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home>
{
  String title="loading.....";
  String completed="Loading....";
  void setTodo() async
  {
    Todo todo = Todo(id:'1');
    await todo.getApiData();
   setState(() {
     title=todo.title;
     completed=todo.completed.toString();
   });
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: const Text('flutter app'),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.start,
        children: [
          Text('todo title: $title'),
          Text('todo status: $completed'),
        ],
      ),
    );
  }

  @override
  void initState()
  {
    super.initState();
    setTodo();
  }
}