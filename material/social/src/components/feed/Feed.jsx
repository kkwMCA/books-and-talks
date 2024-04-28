import Post from "../post/Post";
import Share from "../share/Share";
import "./feed.css";
// import { Posts } from "../../dummyData";
import React, { useState, useEffect } from "react";
import axios from "axios";

const baseURL = "http://localhost:8081/getAllPost";
export default function Feed() {

  const [post, setPost] = React.useState(null);

  React.useEffect(() => {
    axios.get(baseURL).then((response) => {
      setPost(response.data);
    });
  }, []);

  if (!post) return null;

  return (
    <div>
      <h1>{post.username}</h1>
      
    </div>
  );
  // return (
  //   <div className="feed">
  //     <div className="feedWrapper">
  //       <Share />
  //       <p>data.postname</p>
  //     </div>
  //   </div>
  // );
}
