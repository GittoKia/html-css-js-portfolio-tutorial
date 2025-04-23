const express = require('express');
const path    = require('path');
const { spawn } = require('child_process');
const app = express();

// Serve static assets in /public
app.use(express.static(path.join(__dirname, 'public')));

// Root route fallback (if no index.html or you want custom behavior)
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

// Your Java endpoint
app.get('/run-goodbye', (req, res) => {
  const java = spawn('java', [
    '-cp', 'build/classes',
    'myabbasikiamethodsassignment.Main'
  ]);

  let out = '', err = '';
  java.stdout.on('data', d => out += d.toString());
  java.stderr.on('data', d => err += d.toString());
  java.on('close', code => {
    if (code === 0) res.send(`<pre>${out}</pre>`);
    else           res.status(500).send(`<pre>Error:\n${err}</pre>`);
  });
});

const port = process.env.PORT || 10000;
app.listen(port, () => console.log(`Listening on ${port}`));