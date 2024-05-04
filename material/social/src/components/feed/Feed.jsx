// import Post from "../post/Post";
// import Share from "../share/Share";
import pdf from "./Untitled.png"
import "./feed.css";
// import { Posts } from "../../dummyData";
import React, { useState, useEffect } from "react";
import axios from "axios";

const baseURL = "/api/get";
export default function Feed() {

  const [data, setData] = useState(null);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  const [file, setFile] = useState(null);
  const [desc, setDesc] = useState(null);
  const [postname, setPostName] = useState(null);
  const [community, setCommunity] = useState(null);

  // const [like, setLike] = useState(null);
  const fetchData = async () => {
    setIsLoading(true);
    try {
      const response = await axios.get(baseURL);
      setData(response.data);
    } catch (error) {
      setError(error);
    } finally {
      setIsLoading(false);
      
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  if (isLoading) return <div>Loading...</div>;

  if (error) return <div>Error: {error.message}</div>;

  if (!data) return null;


  console.log(data.post)

  function handleForm(e) {
    e.preventDefault();

    const data = new FormData();
    data.append("image", file);
    data.append("postname", postname);
    data.append("desc", desc)
    data.append("community", community)

    console.log(data);
    fetch("/post", {
      method: "POST",
      body: data,
    });
    
  }

  function handleLikes(e, postId) {
    e.preventDefault();

    console.log(postId);
    const data = new FormData();
    data.append("id", postId); // Assuming postId represents the post's id


    fetch("/like", {
      method: "POST",
      body: data,
    });
  }

  function handleDislikes(e, postId) {
    e.preventDefault();

    console.log(postId);
    const data = new FormData();
    data.append("id", postId); // Assuming postId represents the post's id


    fetch("/dislike", {
      method: "POST",
      body: data,
    });
  }
  // function handleDownload(e, postId) {
  //   e.preventDefault();

  //   console.log(postId);
  //   const data = new FormData();
  //   data.append("id", postId); // Assuming postId represents the post's id


  //   fetch("/download", {
  //     method: "GET",
  //     body: data,
  //   });
  // }

  // function handleDownload(e, postId) {
  //   e.preventDefault();
  
  //   console.log(postId);
  
  //   // Build the URL with the query parameter
  //   const url = new URL("/download", window.location.origin);
  //   url.searchParams.append("id", postId);
  
  //   // Use the GET method with the constructed URL
  //   fetch(url.toString(), {
  //     method: "GET"
  //   })
  //   .then(response => {
  //     // Handle the response, e.g., download the file
  //     if (!response.ok) {
  //       throw new Error(`HTTP error! status: ${response.status}`);
  //     }
  
  //     // Handle successful download (content type and data manipulation might be needed based on server response)
  //     return response.blob(); // Assuming the response is a downloadable file
  //   })
  //   .then(blob => {
  //     // Create a downloadable link or trigger file download behavior
  //     let contentType = blob.type; // Get the content type of the blob
  //       let extension = '';
  //       if (contentType.includes('image')) {
  //           extension = 'jpg'; // Set extension for images
  //       } else if (contentType.includes('pdf')) {
  //           extension = 'pdf'; // Set extension for PDFs
  //       } else {
  //           throw new Error('Unsupported file type.');
  //       }

  //       // Create a downloadable link or trigger file download behavior
  //       const link = document.createElement('a');
  //       link.href = URL.createObjectURL(blob);
  //       link.download = `post_${postId}.${extension}`; // Set appropriate filename with extension
  //       link.click();
  //     })
  //   .catch(error => {
  //     alert("Error downloading file:", error);
  //     // Handle download errors gracefully (e.g., display an error message to the user)
  //   });
  // }
  
//   function handleDownload(e, postId,) {


//     fetch(`/download?id=${postId}`)
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error('Network response was not ok.');
//             }
//             console.log(response.content)
//             return response.blob();
//         })
//         .then(blob => {
//             let extension = '';

//             if (fileType === 'pdf') {
//                 extension = 'pdf';
//             } else {
//                 // Detect file type based on the blob's content
//                 if (blob.type.includes('pdf')) {
//                     extension = 'pdf';
//                 } else if (blob.type.includes('image')) {
//                     extension = 'jpg';
//                 } else {
//                     throw new Error('Unsupported file type.');
//                 }
//             }

//             // Create a downloadable link or trigger file download behavior
//             const link = document.createElement('a');
//             link.href = URL.createObjectURL(blob);
//             link.download = `post_${postId}.${extension}`; // Set appropriate filename with extension
//             link.click();
//         })
//         .catch(error => {
//             console.error('Error downloading file:', error);
//         });
// }

function handleDownload(e,postId) {
  e.preventDefault();
  fetch(`/download?id=${postId}`)
      .then(response => {
          if (!response.ok) {
              throw new Error('Network response was not ok.');
          }
          return response.json(); // Parse response as JSON
      })
      .then(data => {
          let content = data.content;
          let fileData = data.data;

          console.log(data)

          let extension = '';
          if (content === 'application/pdf') {
              extension = 'pdf';
          } else if (content==='image/jpeg') {
              extension = 'jpg';
          } else {
              throw new Error('Unsupported file type.');
          }
          let binaryData = atob(fileData);

          // Convert binary data to ArrayBuffer
          let arrayBuffer = new ArrayBuffer(binaryData.length);
          let uint8Array = new Uint8Array(arrayBuffer);
          for (let i = 0; i < binaryData.length; i++) {
              uint8Array[i] = binaryData.charCodeAt(i);
          }

          // Create a Blob from the ArrayBuffer
          let blob = new Blob([uint8Array], { type: content });

          // Create a downloadable link or trigger file download behavior
          const link = document.createElement('a');
          link.href = URL.createObjectURL(blob);
          link.download = `post_${postId}.${extension}`; // Set appropriate filename with extension
          link.click();
      })
      .catch(error => {
          console.error('Error downloading file:', error);
      });
}



  // function handleDownload(e, postId,ex) {
  //   e.preventDefault();
  
  //   console.log(postId);
  
  //   // Build the URL with the query parameter
  //   const url = new URL("/download", window.location.origin);
  //   url.searchParams.append("id", postId);
  
  //   // Use the GET method with the constructed URL
  //   fetch(url.toString(), {
  //     method: "GET"
  //   })
  //   .then(response => {
  //     // Handle the response, e.g., download the file
  //     if (!response.ok) {
  //       throw new Error(`HTTP error! status: ${response.status}`);
  //     }
  
  //     // Handle successful download (content type and data manipulation might be needed based on server response)
  //     return response.blob(); // Assuming the response is a downloadable file
  //   })
  //   .then(blob => {
  //     // Create a downloadable link or trigger file download behavior
  //     const link = document.createElement('a');
  //     link.href = URL.createObjectURL(blob);
  //     link.download = `post_${postId}.${ex}`; // Set appropriate filename extension
  //     link.click();
  //   })
  //   .catch(error => {
  //     alert("Error downloading file:", error);
  //     // Handle download errors gracefully (e.g., display an error message to the user)
  //   });
  // }


  function handleFileChange(e) {
    if (e.target.files && e.target.files[0]) setFile(e.target.files[0]);
  }
  return (
    <div className="container">
      <div className="upload-container">
        {/* Upload form */}
        <form className="upload-form">
          <input
            type="text"
            placeholder="Enter your postname"
            onChange={(e) => { setPostName(e.target.value) }}
            value={postname}
            required
          />
          <input
            type="text"
            placeholder="Enter your description"
            onChange={(e) => { setDesc(e.target.value) }}
            value={desc}
            required
          />
          <input
            type="text"
            placeholder="Enter your Community"
            onChange={(e) => { setCommunity(e.target.value) }}
            value={community}
            required
          />
          <input
            type="file"
            name="image"
            onChange={handleFileChange}
          />
          <button type="submit" onClick={(e) => handleForm(e)}>Add Post</button>
        </form>
      </div>

      <div className="feed-posts">
        {/* Post rendering */}
        {data.slice().reverse().map((post, index) => (
          <div key={index} className="post-card">
            <div className="user-profile">
              <img src = "/assets/person/programmer.png" alt="User" className="user-photo" />
              <p className="user-id">{post.postname}</p><br></br>

            </div>
            <strong>{post.community}</strong>
            {post.content === 'application/pdf' ? (
  <img
    src={pdf}
    alt="Post"
    className="post-image"
  />
) : (
  <img src={`data:image/jpeg;base64, ${post.img}`} alt="Post" className="post-image" />
)}
            
              
            <p className="post-description">Description: {post.description}</p>
            <div className="button-container">
              <button className="like-button" onClick={(e) => handleLikes(e, post.postid)}>Like</button>
              <p className="like-count">{post.likes}</p>
              <button className="dislike-button" onClick={(e) => handleDislikes(e, post.postid)}>Dislike</button>

          
              {/* {post.content === 'application/pdf' ? ( */}
  <button className="download-button" onClick={(e) => handleDownload(e, post.postid)}>Download</button>
{/*// ) : (
//   <button className="download-button" onClick={(e) => handleDownload(e, post.postid,"jpeg")}>Download</button>
// )}*/}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}