// server.js
const express = require('express');
const path    = require('path');
const { spawn } = require('child_process');
const cors    = require('cors');

const app = express();
app.use(cors());

// ─── 1. STATIC FILES ──────────────────────────────────────────────────────────
// Serve everything in ./public at the root URL
app.use(express.static(path.join(__dirname, 'public')));

// ─── 2. JAVA ENDPOINTS ────────────────────────────────────────────────────────
app.get('/run-java', (req, res) => {
  const javaProcess = spawn('java', [
    '-cp', 'JavaClasses',
    'AbbasiKiaArraysAssignmentUI'
  ]);

  let output = '', errors = '';
  javaProcess.stdout.on('data', d => output += d.toString());
  javaProcess.stderr.on('data', d => errors += d.toString());

  javaProcess.on('close', code => {
    if (code === 0) res.send(`<pre>${output}</pre>`);
    else           res.status(500).send(`<pre>Error:\n${errors}</pre>`);
  });
});

app.get('/run-goodbye', (req, res) => {
  const javaProcess = spawn("java", [
    "-cp", "build/classes:.",
    "myabbasikiamethodsassignment.AbbasiKiaMethodsAssignmentUI"
  ]);

  let output = '', errors = '';
  javaProcess.stdout.on('data', d => output += d.toString());
  javaProcess.stderr.on('data', d => errors += d.toString());

  javaProcess.on('close', code => {
    if (code === 0) res.send(`<pre>${output}</pre>`);
    else           res.status(500).send(`<pre>Error:\n${errors}</pre>`);
  });
});

// ─── 3. PYTHON ENDPOINT ───────────────────────────────────────────────────────
app.get('/run-python', (req, res) => {
  // Use python3 on Linux containers
  const pythonProcess = spawn('python3', ['Minesweeper.py']);

  let output = '', errors = '';
  pythonProcess.stdout.on('data', d => output += d.toString());
  pythonProcess.stderr.on('data', d => errors += d.toString());

  pythonProcess.on('close', code => {
    if (code === 0) res.send(`<pre>${output}</pre>`);
    else           res.status(500).send(`<pre>Error:\n${errors}</pre>`);
  });
});

// ─── 4. CATCH-ALL (optional) ─────────────────────────────────────────────────
// If you want all unknown routes to return index.html (for a SPA):
// app.get('*', (req, res) => {
//   res.sendFile(path.join(__dirname, 'public', 'index.html'));
// });

// ─── 5. START SERVER ─────────────────────────────────────────────────────────
const port = process.env.PORT || 10000;
app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});
