--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.3
-- Dumped by pg_dump version 9.2.3
-- Started on 2015-05-21 16:05:15 BRT

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 174 (class 3079 OID 11995)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2220 (class 0 OID 0)
-- Dependencies: 174
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 18608)
-- Name: alunos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE alunos (
    id_aluno integer NOT NULL,
    nm_aluno character varying(255),
    ds_trabalho character varying(255),
    id_orientador integer
);


ALTER TABLE public.alunos OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 18606)
-- Name: alunos_id_aluno_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE alunos_id_aluno_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.alunos_id_aluno_seq OWNER TO postgres;

--
-- TOC entry 2221 (class 0 OID 0)
-- Dependencies: 170
-- Name: alunos_id_aluno_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE alunos_id_aluno_seq OWNED BY alunos.id_aluno;


--
-- TOC entry 173 (class 1259 OID 18624)
-- Name: avaliacoes; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE avaliacoes (
    id_avaliacao integer NOT NULL,
    id_aluno integer,
    nm_avaliador character varying(255),
    ds_consideracoes character varying(255)
);


ALTER TABLE public.avaliacoes OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 18622)
-- Name: avaliacoes_id_avaliacao_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE avaliacoes_id_avaliacao_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.avaliacoes_id_avaliacao_seq OWNER TO postgres;

--
-- TOC entry 2222 (class 0 OID 0)
-- Dependencies: 172
-- Name: avaliacoes_id_avaliacao_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE avaliacoes_id_avaliacao_seq OWNED BY avaliacoes.id_avaliacao;


--
-- TOC entry 169 (class 1259 OID 18600)
-- Name: professores; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE professores (
    id_professor integer NOT NULL,
    nm_professor character varying(255)
);


ALTER TABLE public.professores OWNER TO postgres;

--
-- TOC entry 168 (class 1259 OID 18598)
-- Name: professores_id_professor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE professores_id_professor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.professores_id_professor_seq OWNER TO postgres;

--
-- TOC entry 2223 (class 0 OID 0)
-- Dependencies: 168
-- Name: professores_id_professor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE professores_id_professor_seq OWNED BY professores.id_professor;


--
-- TOC entry 2197 (class 2604 OID 18611)
-- Name: id_aluno; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY alunos ALTER COLUMN id_aluno SET DEFAULT nextval('alunos_id_aluno_seq'::regclass);


--
-- TOC entry 2198 (class 2604 OID 18627)
-- Name: id_avaliacao; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY avaliacoes ALTER COLUMN id_avaliacao SET DEFAULT nextval('avaliacoes_id_avaliacao_seq'::regclass);


--
-- TOC entry 2196 (class 2604 OID 18603)
-- Name: id_professor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY professores ALTER COLUMN id_professor SET DEFAULT nextval('professores_id_professor_seq'::regclass);


--
-- TOC entry 2210 (class 0 OID 18608)
-- Dependencies: 171
-- Data for Name: alunos; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2224 (class 0 OID 0)
-- Dependencies: 170
-- Name: alunos_id_aluno_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('alunos_id_aluno_seq', 1, false);


--
-- TOC entry 2212 (class 0 OID 18624)
-- Dependencies: 173
-- Data for Name: avaliacoes; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2225 (class 0 OID 0)
-- Dependencies: 172
-- Name: avaliacoes_id_avaliacao_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('avaliacoes_id_avaliacao_seq', 1, false);


--
-- TOC entry 2208 (class 0 OID 18600)
-- Dependencies: 169
-- Data for Name: professores; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2226 (class 0 OID 0)
-- Dependencies: 168
-- Name: professores_id_professor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('professores_id_professor_seq', 1, false);


--
-- TOC entry 2202 (class 2606 OID 18616)
-- Name: alunos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY alunos
    ADD CONSTRAINT alunos_pkey PRIMARY KEY (id_aluno);


--
-- TOC entry 2204 (class 2606 OID 18632)
-- Name: avaliacoes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY avaliacoes
    ADD CONSTRAINT avaliacoes_pkey PRIMARY KEY (id_avaliacao);


--
-- TOC entry 2200 (class 2606 OID 18605)
-- Name: professores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY professores
    ADD CONSTRAINT professores_pkey PRIMARY KEY (id_professor);


--
-- TOC entry 2205 (class 2606 OID 18617)
-- Name: alunos_id_orientador_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY alunos
    ADD CONSTRAINT alunos_id_orientador_fkey FOREIGN KEY (id_orientador) REFERENCES professores(id_professor);


--
-- TOC entry 2206 (class 2606 OID 18633)
-- Name: avaliacoes_id_aluno_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY avaliacoes
    ADD CONSTRAINT avaliacoes_id_aluno_fkey FOREIGN KEY (id_aluno) REFERENCES alunos(id_aluno);


--
-- TOC entry 2219 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-05-21 16:05:15 BRT

--
-- PostgreSQL database dump complete
--

