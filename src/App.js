import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {

  const [items, setItems] = useState([]);

  useEffect(() => {
    fetchItems();
  }, []);

  const fetchItems = async () => {
    const response = await axios.get("http://localhost:8080/lost");
    setItems(response.data);
  };

  return (
    <div style={{padding:"20px"}}>
      <h1>Lost and Found Management System</h1>

      <h2>Lost Items</h2>

      {items.map(item => (
        <div key={item.id}>
          <b>{item.itemName}</b> - {item.description} - {item.location}
        </div>
      ))}
    </div>
  );
}

export default App;