const express = require('express');
const { spawn } = require('child_process');
const app = express();

app.get('/run-goodbye', (req, res) => {
  const java = spawn('java', [
    '-cp', 'build/classes',
    'myabbasikiamethodsassignment.AbbasiKiaMethodsAssignmentUI'
  ]);

  let out = '', err = '';
  java.stdout.on('data', d => out += d.toString());
  java.stderr.on('data', d => err += d.toString());

  java.on('close', code => {
    if (code === 0) res.send(`<pre>${out}</pre>`);
    else           res.status(500).send(`<pre>Error:\n${err}</pre>`);
  });
});

// launch server
const port = process.env.PORT || 10000;
app.listen(port, () => {
  console.log(`Listening on port ${port}`);
});