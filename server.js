const express = require('express');
const { spawn } = require('child_process');
const cors = require('cors');

const app = express();
app.use(cors());

// Endpoint to run AbbasiKiaArraysAssignmentUI (or similar)
app.get('/run-java', (req, res) => {
  // Spawn process using class from JavaClasses folder
  const javaProcess = spawn('java', ['-cp', 'JavaClasses', 'AbbasiKiaArraysAssignmentUI']);

  let outputData = '';
  let errorData = '';

  javaProcess.stdout.on('data', (data) => {
    outputData += data.toString();
  });

  javaProcess.stderr.on('data', (data) => {
    errorData += data.toString();
  });

  javaProcess.on('close', (code) => {
    if (code === 0) {
      res.send(`<pre>${outputData}</pre>`);
    } else {
      res.status(500).send(`<pre>Error: ${errorData}</pre>`);
    }
  });
});

// NEW endpoint to run the Goodbye java file.
app.get('/run-goodbye', (req, res) => {
  // Make sure that the Goodbye.class is compiled into the JavaClasses folder.
  const javaProcess = spawn('java', ['-cp', 'MethodsClasses', 'AbbasiKiaMethodsAssignmentUI']);
  

  let outputData = '';
  let errorData = '';

  javaProcess.stdout.on('data', (data) => {
    outputData += data.toString();
  });

  javaProcess.stderr.on('data', (data) => {
    errorData += data.toString();
  });

  javaProcess.on('close', (code) => {
    if (code === 0) {
      res.send(`<pre>${outputData}</pre>`);
    } else {
      res.status(500).send(`<pre>Error: ${errorData}</pre>`);
    }
  });
});

app.get('/run-python', (req, res) => {
  // Spawn the python process; use 'python' or 'python3' as needed
  const pythonProcess = spawn('py', ['Minesweeper.py']);

  let outputData = '';
  let errorData = '';

  pythonProcess.stdout.on('data', (data) => {
    outputData += data.toString();
  });

  pythonProcess.stderr.on('data', (data) => {
    errorData += data.toString();
  });

  pythonProcess.on('close', (code) => {
    if (code === 0) {
      res.send(`<pre>${outputData}</pre>`);
    } else {
      res.status(500).send(`<pre>Error: ${errorData}</pre>`);
    }
  });
});

const port = 3001;
app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});