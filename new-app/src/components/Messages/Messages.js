import React from 'react';

import ScrollToBottom from 'react-scroll-to-bottom';

import Message from './Message/Message';

import './Messages.css';

//  displaying messages on screen

const Messages = ({messages, name}) => (
  <ScrollToBottom className="messages">
    {messages.map((message, i) => 
    <div key={i}>
      {/* {console.log(message)} */}
      <Message message={message} name={name}/>
    </div>)}
  </ScrollToBottom>
);

export default Messages;