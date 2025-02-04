import React, {useState} from 'react';
import {Button, Container, Form, InputGroup} from "react-bootstrap";
import {addProduct} from "../api/Axios";

const InputBar = () => {
    const [product, setProduct] = useState(
        {
            name: "",
            description: ""
        }
    )
    const {name, description} = product
    const onInputChange = (e) => {
        setProduct({...product, [e.target.name]: e.target.value})
    }

    return (
        <Container className="w-50">
            <InputGroup className="mb-2">
                <InputGroup.Text id="inputGroup-sizing-default">
                    Name
                </InputGroup.Text>
                <Form.Control
                    aria-label="Default"
                    aria-describedby="inputGroup-sizing-default"
                    id="name"
                    name="name"
                    type="name"
                    value={name || ''}
                    onChange={(e) => onInputChange(e)}
                />
            </InputGroup>
            <InputGroup className="mb-3">
                <InputGroup.Text id="inputGroup-sizing-default">
                    Description
                </InputGroup.Text>
                <Form.Control
                    aria-label="Default"
                    aria-describedby="inputGroup-sizing-default"
                    id="description"
                    name="description"
                    type="description"
                    value={description || ''}
                    onChange={(e) => onInputChange(e)}
                />
            </InputGroup>
            <Button onClick={
                function () {
                    addProduct(product)
                        .then(r => {console.log(r.data)})
                    window.location.href = "/"
                }
            }>Submit</Button>
        </Container>
    );
};

export default InputBar;