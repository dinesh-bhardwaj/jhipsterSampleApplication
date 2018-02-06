import { BaseEntity } from './../../shared';

export class RNS_REFR_DETAILS implements BaseEntity {
    constructor(
        public id?: number,
        public rEFRID?: string,
        public sUBCODE?: string,
        public sUBCODEDESC?: string,
        public sTATUS?: string,
        public cREATEDBY?: string,
        public cREATEDDATE?: any,
        public lASTMODIFIEDBY?: string,
        public lASTMODIFIEDDATE?: any,
        public masterIds?: BaseEntity[],
    ) {
    }
}
