import React, { useState } from 'react';
import { books as items } from './book-data';
import BookPage from './pages/bookPage';
import './index.css';

export default function App() {
  const addToCart = (item) => {
      let index = items.findIndex((obj) => obj.id === item.id);
      items[index].quantity = items[index].quantity + 1;

      console.log('items: ', items);
      return { ...items };
  };

  const removeItem = (item) => {
    let index = items.findIndex((i) => i.id === item.id);
    if (index >= 0) {
      if (items[index].quantity > 0) {
        items[index].quantity = items[index].quantity - 1;
      }

      console.log('items: ', items);
      return { ...items };
    }
  };

  const listToPost = () => {
    let list = items.filter(item => (!!item.quantity)).map(item => ({ref: `ref-${item.id}`, quantity: item.quantity}))
    return list;
  }
  // NOTE: Items List doesn't refresh here! quantity displayed wrongly!
  return (
    <div className="app">
      {console.log('items', items)}
      <main className="app-content">
        <Content
          onAddToCart={addToCart}
          itemsList={items}
          onRemoveItem={removeItem}
        />
        <hr></hr>
        {/* Send To Backend: {listToPost} */}
      </main>
    </div>
  );
}

const Content = ({ itemsList, onAddToCart, onRemoveItem }) => {
  return (
    <BookPage
      items={itemsList}
      onAddOne={onAddToCart}
      onRemoveOne={onRemoveItem}
    />
  );
};
