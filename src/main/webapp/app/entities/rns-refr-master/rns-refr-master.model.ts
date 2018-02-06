import { BaseEntity } from './../../shared';

export class RNS_REFR_MASTER implements BaseEntity {
    constructor(
        public id?: number,
        public rNSCATGCODE?: string,
        public sUBCODE1?: string,
        public sUBCODEDESC1?: string,
        public sUBCODE2?: string,
        public sUBCODEDESC2?: string,
        public sUBCODE3?: string,
        public sUBCODEDESC3?: string,
        public sUBCODE4?: string,
        public sUBCODEDESC4?: string,
        public sUBCODE5?: string,
        public sUBCODEDESC5?: string,
        public sUBCODE6?: string,
        public sUBCODEDESC6?: string,
        public sUBCODE7?: string,
        public sUBCODEDESC7?: string,
        public sUBCODE8?: string,
        public sUBCODEDESC8?: string,
        public sUBCODE9?: string,
        public sUBCODEDESC9?: string,
        public sUBCODE10?: string,
        public sUBCODEDESC10?: string,
        public sTATUS?: string,
        public cREATEDBY?: string,
        public cREATEDDATE?: any,
        public lASTMODIFIEDBY?: string,
        public lASTMODIFIEDDATE?: any,
        public iDS?: BaseEntity[],
        public rNSCATGMASTER?: BaseEntity,
    ) {
    }
}
