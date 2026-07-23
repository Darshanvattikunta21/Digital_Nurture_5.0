// HOL 1 - Introduction to React
// React is a JavaScript library for building user interfaces
// JSX lets us write HTML inside JavaScript
import React from 'react';

function App() {
  // this is JSX - it looks like HTML but it is JavaScript
  return (
    <div style={{ fontFamily: 'Arial', padding: '20px' }}>
      <h1 style={{ color: 'blue' }}>HOL 1 - Introduction to React</h1>

      <h2>What is React?</h2>
      <p>React is a JavaScript library made by Facebook for building user interfaces.</p>
      <p>It lets us build reusable components and create fast web applications.</p>

      <h2>What is Virtual DOM?</h2>
      <p>Virtual DOM is a copy of the real DOM that React keeps in memory.</p>
      <p>When data changes React updates only the changed parts - making it very fast.</p>

      <h2>What is JSX?</h2>
      <p>JSX stands for JavaScript XML.</p>
      <p>It lets us write HTML code inside JavaScript files.</p>

      <h2>React Features</h2>
      <ul>
        <li>Component Based</li>
        <li>Virtual DOM for fast updates</li>
        <li>Reusable components</li>
        <li>One way data flow</li>
        <li>Easy to learn</li>
      </ul>

      <p>Today is: {new Date().toLocaleDateString()}</p>
    </div>
  );
}

export default App;
