import React, { useState } from 'react';

function Register() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

 
    if (name.length < 5) {
      setError('Name must be at least 5 characters');
    } 
    else if (!email.includes('@') || !email.includes('.')) {
      setError('Email must be valid (contain @ and .)');
    } 
    else if (password.length < 8) {
      setError('Password must be at least 8 characters');
    } 
    else {
      alert(`Registered Successfully!\nName: ${name}\nEmail: ${email}`);
      setName('');
      setEmail('');
      setPassword('');
      setError('');
    }
  };

  return (
    <div style={{textAlign:'center',margin:'200px'}}>
      <h2 style={{color:'red'}}>Register Here!!!</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name:</label><br />
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>

        <div>
          <label>Email:</label><br />
          <input
            type="text"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>

        <div>
          <label>Password:</label><br />
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>

        {error && <p style={{ color: 'red' }}>{error}</p>}

        <br />
        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default Register;